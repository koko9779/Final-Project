package com.itwill.staily.mypage.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.mypage.model.dto.Message;
import com.itwill.staily.util.Company;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;

public class MypageTest {
	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		BookmarkMapper bk = applicationContext.getBean(BookmarkMapper.class);
		MypageMapper mp = applicationContext.getBean(MypageMapper.class);
		MessageMapper ms = applicationContext.getBean(MessageMapper.class);
		FriendMapper fm = applicationContext.getBean(FriendMapper.class);
		
		Member m = mp.selectMemberCompany(7);
		System.out.println(m);
					
		
		/*
		Member member = fm.findFriend("hiphopmy");
		System.out.println(member.getmId());
		*/
		
		
		/*
		List<Message> messageList = ms.selectMessageList(2);
		for (Message message : messageList) {
			System.out.println(message.getmNo()+", "+message.getMsContent()+","+message.getMember().getmId());
		}
		
		List<Bookmark> bookmarkList = bk.selectList(2);
		for (Bookmark bookmark : bookmarkList) {
			System.out.println(bookmark.getBmNo()+","+bookmark.getMember().getmId()+","+bookmark.getProduct().getpName());
		}
		*/
		
		//System.out.println(mp.selectOne(2));
		
		
		//System.out.println(bk.deleteBookmark(1));
		
		//Bookmark book = new Bookmark(1, member.setmNo(1), product.setpNo(1));
		//System.out.println(bk.createBookmark(book));
				
		
		/*
		PaymentMapper py = applicationContext.getBean(PaymentMapper.class);
		System.out.println(py.selectOne(1));
		
		
		Member member = new Member(7, "id변경", "1234", "7변경", "주소변경", "주소디테일변경", "이메일변경", "T", "000000", null);
		//Member(int mNo, String mId, String mPw, String mName, String mAddress, String mDaddress, String mEmail,
		//		String mType, String mPhone, Company mCompany)
		
		
		System.out.println(mp.updateMember(member));
		*/
		
		
		
	}

}
