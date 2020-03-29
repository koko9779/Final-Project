package com.itwill.staily.login.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.util.Member;

public class SignUpMapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		SignUpMapper sign = applicationContext.getBean(SignUpMapper.class);
		int count;

		//두 작업은 한번에 이루어져야한다(한번 실행할 때 두 작업이 순차적으로 모두 이뤄져야 함)
		//트랜잭션 관리때문에 한번에 실행 안하면 시퀀스.currval에서 오류남
		
		//sequence.currval값은 한 session에서만 존재하는 임시값입니다.
		//currval값은 세션에서 마지막으로 call한 nextval에 의해 리턴된 값에 의해 정의 됩니다.
		//만일 세션에서 nextval값이 아직 call되지 않았다면 currval 값은 정의 되지 않습니다.
		//한 세션에서 nextval을 먼저해야 currval을 할수 있읍니다.
		//이유는 첫번째 nextval function이 해당 seq 를 초기화시키기 때문입니다
		
//		Member member = new Member();
//		member.setmId("시험용기업아이디");
//		member.setmPw("1111");
//		member.setmName("로떼");
//		member.setmAddress("알게뭡니까");
//		member.setmDaddress("알게뭡니까22");
//		member.setmEmail("lotte@lotte");
//		member.setmType("C");
//		member.setmPhone("01044445555");
//		count = sign.createMember(member);
//		System.out.println(count);
//		
//		count = sign.createCompany(12345678);
//		System.out.println(count);
		
		
		
		
		
		
		
		
		
	}
	
}
