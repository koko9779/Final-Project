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
		
		//댓글 단위 테스트
		//List<Reply> rL = rs.selectReplyList(1);
		//System.out.println(rL);
		
		//boolean create = rs.createReply(new Reply(21, 1, "저도 사고 싶어요!!", 322353, 0));
		//System.out.println(create);
		
		//boolean delete = rs.deleteReply(new Reply(21, 1, 1));
		//System.out.println(delete);
		
		//상품 단위 테스트
		//Product pro = pd.selectProductOne(21);
		//System.out.println(pro);
		
		//boolean create = pd.createProduct(new Product(1, 2, "컴퓨터 갖고싶다", 2000000, "ㅠㅠㅠ", "첫 월급 받으면", "사야지", "n", 234253));
		//System.out.println(create);
		
		//boolean create = pd.createProductDetail(new Product(6, "팀장님", "스고이"));
		//System.out.println(create);
		
		//작품 단위 테스트
		//Work work = wd.selectWorkOne(3);
		//System.out.println(work);
		
		//List<Work> wL = wd.selectWorkAll();
		//System.out.println(wL);
		
		//boolean create = wd.createWorkDetail(21, 3, 10);
		//System.out.println(create);
		
		((ConfigurableApplicationContext)applicationContext).close();

	}

}
