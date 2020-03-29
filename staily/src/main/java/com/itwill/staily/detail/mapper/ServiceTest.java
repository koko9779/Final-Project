package com.itwill.staily.detail.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.detail.model.dto.Reply;
import com.itwill.staily.detail.service.ProductDetailServiceImpl;
import com.itwill.staily.detail.service.ReplyServiceImpl;
import com.itwill.staily.detail.service.WorkDetailServiceImpl;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@SuppressWarnings("unused")
public class ServiceTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		ProductDetailServiceImpl pd = applicationContext.getBean(ProductDetailServiceImpl.class);
		ReplyServiceImpl rs = applicationContext.getBean(ReplyServiceImpl.class);
		WorkDetailServiceImpl wd = applicationContext.getBean(WorkDetailServiceImpl.class);
		
		//´ñ±Û ´ÜÀ§ Å×½ºÆ®
		//List<Reply> rL = rs.selectReplyList(1);
		//System.out.println(rL);
		
		//boolean create = rs.createReply(new Reply(21, 1, "Àúµµ »ç°í ½Í¾î¿ä!!", 322353, 0));
		//System.out.println(create);
		
		//boolean delete = rs.deleteReply(new Reply(21, 1, 1));
		//System.out.println(delete);
		
		//boolean inc = rs.increaseRecommend(28);
		//System.out.println(inc);
		
		//boolean inc = rs.increaseReport(28);
		//System.out.println(inc);
		
		//»óÇ° ´ÜÀ§ Å×½ºÆ®
		//Product pro = pd.selectProductOne(21);
		//System.out.println(pro);
		
		//boolean create = pd.createProduct(new Product(1, 2, "ÄÄÇ»ÅÍ °®°í½Í´Ù", 2000000, "¤Ð¤Ð¤Ð", "Ã¹ ¿ù±Þ ¹ÞÀ¸¸é", "»ç¾ßÁö", "n", 234253));
		//System.out.println(create);
		
		//boolean create = pd.createProductDetail(new Product(6, "ÆÀÀå´Ô", "½º°íÀÌ"));
		//System.out.println(create);
		
		//boolean update = pd.updateProduct(new Product("ÇÚµåÆù »ç°í½Í´Ù", 1500000, "¾ß³ÊµÎ?", "Áö±¸", "¾Æ½Ã¾Æ", "n", 345362, 22));
		//System.out.println(update);
				
		//boolean update = pd.updateProductDetail(new Product("ÈÄÄoÆRÁK¤¾¤Ã¤¿", "¤¾¤¾Âm", 1));
		//System.out.println(update);				
		
		//ÀÛÇ° ´ÜÀ§ Å×½ºÆ®
		//Work work = wd.selectWorkOne(3);
		//System.out.println(work);
		
		//List<Work> wL = wd.selectWorkAll();
		//System.out.println(wL);
		
		//boolean create = wd.createWorkDetail(21, 3, 10);
		//System.out.println(create);
		
		((ConfigurableApplicationContext)applicationContext).close();

	}

}
