package com.itwill.staily.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.admin.service.NaverLogin;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;
/************Naver**************/
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	public AdminController() {
	}
	/*
	 * 만들어야할거... 회원 ,작품, 상품 수정 form(아에 form.jsp도 만들어야함) action 삭제 action들
	 * 
	 */
	@RequestMapping("/main")
	public String adminTest() {
		return "admin/index";
	}

	// 회원
	@RequestMapping("/member")
	public String memberAdminForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Member> memberList = new ArrayList();
			memberList = adminService.selectMemberAll();
			request.setAttribute("data", memberList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/member";
	}

	@RequestMapping("/member_delete")
	@ResponseBody
	public String memberAdminDelete(@RequestParam("mNo") int mNo, HttpServletRequest request) {
		String result = "fail";
		try {
			adminService.deleteMember(mNo);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}

	@RequestMapping("/member_select")
	public String memberAdminUpdate(HttpServletRequest request) {
		int mNo = Integer.parseInt(request.getParameter("mNo"));
		Member member = null;
		try {
			member = adminService.selectMemberOne(mNo);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/member_update";
	}

	@RequestMapping(value = "/member_update", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String memberAdminUpdateA(@RequestParam("mNo") int mNo, @RequestParam("mId") String mId,
			@RequestParam("mPw") String mPw, @RequestParam("mName") String mName,
			@RequestParam("mAddress") String mAddress, @RequestParam("mDaddress") String mDaddress,
			@RequestParam("mEmail") String mEmail, @RequestParam("mType") String mType, HttpServletRequest request) {
		String phn1 = request.getParameter("phn1");
		String phn2 = request.getParameter("phn2");
		String phn3 = request.getParameter("phn3");
		String mPhone = phn1 + phn2 + phn3;
		Member member = new Member(mNo, mId, mPw, mName, mAddress, mDaddress, mEmail, mType, mPhone);
		String result = "";
		try {
			boolean updateOk = adminService.updateMember(member);
			if (updateOk) {
				result = "success";
			} else {
				result = "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}

	// 상품
	@RequestMapping("/product")
	public String productAdminForm(HttpServletRequest request) {
		try {
			List<Product> productList = new ArrayList();
			productList = adminService.selectProductAll();
			request.setAttribute("data", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/product";
	}

	@RequestMapping("/product_select")
	public String productAdminSelect(@RequestParam int pNo, HttpServletRequest request) {
		try {
			List<Product> productList = new ArrayList();
			productList = adminService.selectProductOne(pNo);
			request.setAttribute("productList", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/product_update";
	}

	@RequestMapping("/product_update_img")
	public String productAdminImg(@RequestParam int pNo, HttpServletRequest request) {
		try {
			List<Product> productList = new ArrayList();
			productList = adminService.selectProductOne(pNo);
			request.setAttribute("productList", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/product_update_img";
	}

	@RequestMapping(value = "/update_img")
	public void upload(HttpServletResponse response, HttpServletRequest request,
			@RequestParam("Filedata") MultipartFile Filedata) {
		String filename = "";
		String path = "";
		if (request.getAttribute("pdScene") != null) {
			filename = (String) request.getAttribute("pScene");
			path = "scene";
		} else {
			filename = (String) request.getAttribute("pdImage");
			path = "image";
		}
		File f = new File("C:\\Users\\stu\\git\\Final-Project\\staily\\src\\main\\webapp\\images\\product\\" + path
				+ "\\" + filename + ".jpg");
		try {
			Filedata.transferTo(f);
			response.getWriter().write(filename);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/product_update")
	@ResponseBody
	public String productAdminUpdate(@RequestParam("pNo") int pNo, @RequestParam("mNo") int mNo,
			@RequestParam("wNo") int wNo, @RequestParam("pName") String pName, @RequestParam("pPrice") int pPrice,
			@RequestParam("pURL") String pUrl, @RequestParam("pAddress") String pAddress,
			@RequestParam("pDaddress") String pDaddress, @RequestParam("pCheck") String pCheck,
			@RequestParam("pView") int pView, @RequestParam("pDate") String pDate,
			@RequestParam("pScene") String pScene) {
		Product product = new Product(pNo, mNo, wNo, pName, pPrice, pUrl, pAddress, pDaddress, pCheck, pView, pDate,
				pScene);
		String result = "";
		try {
			adminService.updateProduct(product);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "/product_confirm", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String productAdminConfirm(@RequestParam("pNo") int pNo, HttpServletRequest request) {
		String result = "";
		try {
			boolean confirmOk = adminService.productConfirm(pNo);
			if (confirmOk) {
				result = "success";
			} else {
				result = "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}

	@RequestMapping("/product_delete")
	@ResponseBody
	public String productAdminDelete(@RequestParam("pNo") int pNo, HttpServletRequest request) {
		String result = "fail";
		try {
			adminService.deleteProduct(pNo);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}

	// 작품
	@RequestMapping("/work")
	public String workAdminForm(HttpServletRequest request) {
		try {
			List<Work> workList = new ArrayList();
			workList = adminService.selectWorkAll();
			request.setAttribute("data", workList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/work";
	}

	// TMDB API 검색창
	@RequestMapping("/work_seach")
	public String workAPISeacher() {
		return "admin/work_search";
	}

	@RequestMapping(value = "/work_create")
	public String workAdminCreate(@RequestParam("wName") String wName, @RequestParam("wCategory") String wCategory,
			@RequestParam("wDate") String wDate, @RequestParam("wPoster") String wPoster,
			@RequestParam("wOverview") String wOverview, HttpServletRequest request) {
		Work work = new Work(0, wName, wCategory, wDate, wPoster, 0, 0);
		request.setAttribute("work", work);
		request.setAttribute("wOverview", wOverview);
		return "admin/work_create";
	}

	@RequestMapping("/work_create_action")
	@ResponseBody
	public String workAdminCreateAction(@RequestParam("wName") String wName,
			@RequestParam("wCategory") String wCategory, @RequestParam("wDate") String wDate,
			@RequestParam("wPoster") String wPoster, @RequestParam("wTepisode") int wTepisode,
			HttpServletRequest request) {
		Work work = new Work(0, wName, wCategory, wDate, wPoster, wTepisode, 0);
		String result = "";
		try {
			adminService.createWork(work);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}

	@RequestMapping("/work_select")
	public String workAdminSelect(@RequestParam("wNo") int wNo, HttpServletRequest request) {
		Work work = null;
		try {
			work = adminService.selectWorkOne(wNo);
			request.setAttribute("work", work);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/work_update";
	}

	@RequestMapping(value = "/work_update", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String workAdminUpdate(@RequestParam("wName") String wName, @RequestParam("wCategory") String wCategory,
			@RequestParam("wDate") String wDate, @RequestParam("wPoster") String wPoster,
			@RequestParam("wTepisode") int wTepisode, @RequestParam("wView") int wView, @RequestParam("wNo") int wNo,
			HttpServletRequest request) {
		Work work = new Work(wNo, wName, wCategory, wDate, wPoster, wTepisode, wView);
		String result = "";
		try {
			boolean updateWork = adminService.updateWork(work);
			if (updateWork) {
				result = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}

	/***************************************
	 * Naver
	 *****************************************/
	/* NaverLogin */
	private NaverLogin naverLogin;
	private String apiResult = null;

	@Autowired
	private void setNaverLogin(NaverLogin naverLogin) {
		this.naverLogin = naverLogin;
	}

//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/naver", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLogin클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLogin.getAuthorizationUrl(session);
//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
//네이버
		model.addAttribute("url", naverAuthUrl);
		return "admin/Naver_login";
	}

//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLogin.getAccessToken(session, code, state);
//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLogin.getUserProfile(oauthToken); // String형식의 json데이터
		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
//3. 데이터 파싱
//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
//response의 nickname값 파싱
		String nickname = (String) response_obj.get("nickname");
		System.out.println(nickname);
//4.파싱 닉네임 세션으로 저장
		session.setAttribute("sessionId", nickname); // 세션 생성
		model.addAttribute("result", apiResult);
		return "login";
	}

//로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		System.out.println("여기는 logout");
		session.invalidate();
		return "redirect:index.jsp";
	}
}
