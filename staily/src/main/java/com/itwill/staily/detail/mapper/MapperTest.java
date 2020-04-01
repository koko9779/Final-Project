package com.itwill.staily.detail.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.detail.model.dto.Reply;
import com.itwill.staily.detail.model.dto.ProductEx;
import com.itwill.staily.util.Work;

@SuppressWarnings("unused")
public class MapperTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		ReplyMapper rm = applicationContext.getBean(ReplyMapper.class);
		ProductDetailMapper pdm = applicationContext.getBean(ProductDetailMapper.class);
		WorkDetailMapper wdm = applicationContext.getBean(WorkDetailMapper.class);
		
		//댓글 단위 테스트
		//List<Reply> replyList = rm.selectReplyList(1);
		//System.out.println(replyList);
		
		//Reply rp = rm.selectReplyOne(10);
		//System.out.println(rp);
		
		//boolean create = rm.createReply(new Reply(1, 1, "test", 3, 0));
		//System.out.println(create);
		
		//boolean delete = rm.deleteReply(2, 1, 1);
		//System.out.println(delete);
		
		//boolean inc = rm.increaseRecommend(10);
		//System.out.println(inc);
		
		//boolean inc = rm.increaseReport(10);
		//System.out.println(inc);

		//boolean create = rm.createFriend(3, 6);
		//System.out.println(create);
		
		//상품 단위 테스트
		//ProductEx product = pdm.selectProductOne(3);
		//System.out.println(product);
		
		//boolean create = pdm.createProduct(new ProductEx(4, 6, "BLOOM*IZ", 17000, "http://cafe.daum.net/official-izone", "서울시", "강남구", "N", 4234245));
		//System.out.println(create);
		
		//boolean create = pdm.createProductDetail(new ProductEx(4, "우핳하", "신난다"));
		//System.out.println(create);
		
		//boolean update = pdm.updateProduct(new ProductEx("테슷트", 1500000, "google.com", "서울", "시", "N", 345362, 4));
		//System.out.println(update);
		
		//boolean update = pdm.updateProductDetail(new ProductEx("ㅇㅇ", "ㅋㅋ", 33));
		//System.out.println(update);
		
		//boolean inc = pdm.increaseProductView(3);
		//System.out.println(inc);
		
		//int check = pdm.checkCompany(7);
		//System.out.println(check);
		
		//작품 단위 테스트
		//Work work = wdm.selectWorkOne(3);
		//System.out.println(work);
		
		//List<Work> wL = wdm.selectWorkAll();
		//System.out.println(wL);
		
		//boolean create = wdm.createWorkDetail(21, 3, 10);
		//System.out.println(create);
		
		//int sel = wdm.selectTepisode(1);
		//System.out.println(sel);
				
		((ConfigurableApplicationContext)applicationContext).close();
		
	}

}
