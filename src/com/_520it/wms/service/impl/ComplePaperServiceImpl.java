package com._520it.wms.service.impl;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.StringUtils;

import com._520it.wms.dao.ComplePaperDao;
import com._520it.wms.dao.CutPaperDao;
import com._520it.wms.dao.TitleNumDao;
import com._520it.wms.domain.ComplePaper;
import com._520it.wms.domain.CutPaper;
import com._520it.wms.domain.Employee;
import com._520it.wms.domain.TitleNum;
import com._520it.wms.query.ComplePaperQueryObject;
import com._520it.wms.query.PageResult;
import com._520it.wms.service.ComplePaperService;
import com._520it.wms.util.FileUploadUtil;
import com._520it.wms.util.UserContext;

public class ComplePaperServiceImpl implements ComplePaperService{
	private ComplePaperDao complePaperDao;
	private CutPaperDao cutPaperDao;
	private TitleNumDao titleNumDao;
	

	@Override
	public void save(ComplePaper obj) {
		complePaperDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		ComplePaper complePaper = complePaperDao.get(id);
		FileUploadUtil.deleteFile(complePaper.getImagePath());
		complePaperDao.delete(id);
	}

	@Override
	public void update(ComplePaper obj) {
		complePaperDao.update(obj);
	}

	@Override
	public ComplePaper get(Long id) {
		return complePaperDao.get(id);
	}

	@Override
	public List<ComplePaper> findAll() {
		return complePaperDao.findAll();
	}

	@Override
	public PageResult advanceQuery(ComplePaperQueryObject qo) {
		return complePaperDao.advanceQuery(qo);
	}
	
	
	@Override
	public void batchCutPapers(List<Long> ids) {
		for (int i = 0; i < ids.size(); i++) {
			ComplePaper complePaper = complePaperDao.get(ids.get(i));
			if((complePaper.getIscutted() == null  || !complePaper.getIscutted()) && StringUtils.hasLength(complePaper.getImagePath())){
				String ctx = ServletActionContext.getServletContext().getRealPath("/");
				String srcImageFile = ctx + complePaper.getImagePath();
				String descDir = ctx + "cutimg/";
				if(complePaper.getSubject().getName().equals("英语")){
			    	cutEnglisthImg(complePaper, srcImageFile, descDir);
					
					complePaper.setIscutted(true);
					complePaper.setCutnum(4);
					complePaperDao.update(complePaper);
				}else if(complePaper.getSubject().getName().equals("语文")){
					
				}else if(complePaper.getSubject().getName().equals("数学")){
					
				}
			}
		}
	}

	private void cutEnglisthImg(ComplePaper complePaper, String srcImageFile,
			String descDir) {
		String cutImgDir1 = cut(srcImageFile, descDir, 179, 1488, 2262, 1124, "1");
		cutPaperDao.save(createCutPaperVO(queryOrCreateRootCutPaper(complePaper), complePaper, cutImgDir1, null, 1, 35));
		
		String cutImgDir21 = cut(srcImageFile, descDir, 179, 2604, 2270, 520, "2-1");
		String cutImgDir22 = cut(srcImageFile, descDir, 2545, 217, 2244, 780, "2-2");
		cutPaperDao.save(createCutPaperVO(queryOrCreateRootCutPaper(complePaper), complePaper, cutImgDir21, cutImgDir22, 2, 40));
		
		String cutImgDir3 = cut(srcImageFile, descDir, 2545, 1001, 2244, 928, "3");
		cutPaperDao.save(createCutPaperVO(queryOrCreateRootCutPaper(complePaper), complePaper, cutImgDir3, null, 3, 10));
		
		String cutImgDir41 = cut(srcImageFile, descDir, 2545, 1945, 2244, 1179, "4-1");
		String cutImgDir42 = cut(srcImageFile, descDir, 5079, 41, 2378, 3160, "4-2");
		cutPaperDao.save(createCutPaperVO(queryOrCreateRootCutPaper(complePaper), complePaper, cutImgDir41, cutImgDir42, 4, 15));
	}
	

	private CutPaper queryOrCreateRootCutPaper(ComplePaper complePaper) {
		CutPaper rootCutPaper = cutPaperDao.getRootCutPaperBySubject(complePaper.getSubject().getId());
		if(rootCutPaper == null) {
			rootCutPaper = new CutPaper();
			rootCutPaper.setComplepaper(complePaper);
			cutPaperDao.save(rootCutPaper);
		}
		return rootCutPaper;
	}
	
	private CutPaper createCutPaperVO(CutPaper rootCutPaper, ComplePaper complePaper, String cutImgDir1, String cutImgDir2, int titlenum, int totalscore) {
		CutPaper cutPaper = new CutPaper();
		
		if(StringUtils.hasLength(cutImgDir1)){
			cutPaper.setImagePath1(cutImgDir1);
		}
		if(StringUtils.hasLength(cutImgDir2)){
			cutPaper.setImagePath2(cutImgDir2);
		}
		
		TitleNum tNum = titleNumDao.getTitleNumByNum(titlenum);
		if(tNum == null){
			tNum = new TitleNum(titlenum, complePaper.getSubject());
			titleNumDao.save(tNum);
		}
    	cutPaper.setTitlenum(tNum);
    	cutPaper.setTotalscore(totalscore);
    	cutPaper.setComplepaper(complePaper);
    	cutPaper.setParent(rootCutPaper);
    	cutPaper.setStudent(complePaper.getStudent());
    	
    	return cutPaper;
	}
	
	
	 /**
     * 图像切割  
     * @param srcImageFile 源图像地址  
     * @param descDir      切片目标文件夹  
     * @param destWidth    目标切片宽度  
     * @param destHeight   目标切片高度  
     */  
    public static String cut(String srcImageFile, String descDir, int x, int y, int destWidth, int destHeight, String num) {   
        try {
            //1.读取源图像   
        	File srcImgFile = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(srcImgFile);
            int srcWidth = bi.getWidth();// 源图宽度   
            int srcHeight = bi.getHeight(); // 源图高度
            if (srcWidth > destWidth && srcHeight > destHeight) {   
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);   
                //2.建立切片               
                ImageFilter cropFilter = new CropImageFilter(x, y, destWidth, destHeight);// 四个参数分别为图像起点坐标和宽高   
                Image img = Toolkit.getDefaultToolkit().createImage(   
                                new FilteredImageSource(image.getSource(), cropFilter));   
                BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);   
                Graphics graph = tag.getGraphics();   
                graph.drawImage(img, 0, 0, null); //绘制缩小后的图   
                graph.dispose();   
                //3.输出为文件  
                File dir = new File(descDir);
            	if(!dir.exists()){
            		dir.mkdir();
            	}
            	String srcImgName = srcImgFile.getName().substring(0, srcImgFile.getName().lastIndexOf("."));
                //切割后的原图
                String descFileName = srcImgName + "_"+UUID.randomUUID().toString()+"_cut_" + num;
                String cutImgDir = descDir + descFileName + ".jpg";
                File cutImgFile = new File(cutImgDir);
                ImageIO.write(tag, "JPEG", cutImgFile);
        		//缩略图
                String smallCutImgDir = descDir + descFileName + FileUploadUtil.suffix + ".jpg";
                File smallTargetFile = new File(smallCutImgDir);
        		Thumbnails.of(cutImgFile).scale(0.4f).toFile(smallTargetFile);
                
                return "cutimg/" + descFileName + ".jpg";
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
        return "";
    }   
    
    public PageResult filterPaperByStudent(PageResult pr) {
		List<ComplePaper> result = pr.getResult();
		Employee emp = UserContext.getCurrentEmployee();
		if(emp.getRoleNames().contains("学生")) {
			for (int i = 0; i < result.size(); i++) {
				if(result.get(i).getStudent().getId() != emp.getId() || !(result.get(i).getIsreviewd() != null && result.get(i).getIsreviewd())) {
					result.remove(i);
					i--;
				}
			}
		}
		pr.setResult(result);
		return pr;
	}
	
    
	public ComplePaperDao getComplePaperDao() {
		return complePaperDao;
	}

	public void setComplePaperDao(ComplePaperDao complePaperDao) {
		this.complePaperDao = complePaperDao;
	}

	public CutPaperDao getCutPaperDao() {
		return cutPaperDao;
	}

	public void setCutPaperDao(CutPaperDao cutPaperDao) {
		this.cutPaperDao = cutPaperDao;
	}

	public TitleNumDao getTitleNumDao() {
		return titleNumDao;
	}

	public void setTitleNumDao(TitleNumDao titleNumDao) {
		this.titleNumDao = titleNumDao;
	}
}
