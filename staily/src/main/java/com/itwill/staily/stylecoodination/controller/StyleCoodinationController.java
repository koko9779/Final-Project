package com.itwill.staily.stylecoodination.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.staily.stylecoodination.service.StyleCoodinationService;
import com.itwill.staily.util.Board;

@Controller
@RequestMapping("/style")
public class StyleCoodinationController {
	@Autowired
	 private StyleCoodinationService styleCoodinationService;
	
	@RequestMapping("/style_main_read")
	public String style_main(Model model) {
		List<Board> boardTop10 = new ArrayList<Board>();
		List<Board> data = new ArrayList<Board>();
		int boardCount = 0;
		int replyCount = 0;
		
		boardTop10 = styleCoodinationService.findBoardTop10();
		data = styleCoodinationService.findBoardAll();
		boardCount = styleCoodinationService.findBoardCount();
		replyCount = styleCoodinationService.findBoardReplyCount();
		
		model.addAttribute("boardTop10", boardTop10);
		model.addAttribute("data", data);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("replyCount", replyCount);
		
		return "style/style_main_read";
	}
	
	@RequestMapping("/style_detail_read")
	public String style_view(@RequestParam String bNo, Model model) {
		List<Board> boardOneList = new ArrayList<Board>();
		
		int intBNo = Integer.parseInt(bNo);
		boardOneList = styleCoodinationService.findBoardOne(intBNo);
		model.addAttribute("boardOneList", boardOneList);
		
		return "style/style_detail_read";
	}
	
	/*
	@RequestMapping("/style_board_update")
	public String style_update(@RequestParam String bNo, Model model) {
		int intBNo = Integer.parseInt(bNo);
		Board updateBoard;
		
		updateBoard = styleCoodinationService.selectUpdateBoard(intBNo);
		model.addAttribute("updateBoard", updateBoard);
		
		return "style/style_update";
	}
	*/
	/*
	@Override
	public int modifyBoardAndReply(Board updateBoard) {
		return boardCommonMapper.updateBoardAndReply(updateBoard);
	}
	*/
	
	@RequestMapping("/style_board_create")
	public String style_create(Board board) {
		return "/style/style_board_create";
	}
	
	@RequestMapping(value = "/style_board_create_action", method = RequestMethod.GET)
	public String style_create_action_get(Board board) {
		return "/style/style_board_create";
	}
	
	@RequestMapping(value = "/style_create_board_action", method = RequestMethod.POST)
	public String style_create_action_post(Board board) {
		String forwardPath = "";
		try {
			styleCoodinationService.writeBoard(board);
			forwardPath = "style/style_main_read";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "redirect:/404.jsp";
		}
		return forwardPath;
	}
	
	/*
	@Override
	public int removeBoard(int bNo) {
		return boardManageMapper.deleteBoard(bNo);
	}
	
	@Override
	public int writeReply(Board replyBoard, String mId) {
		int mNo = 0;
		
		// 1. 기존 댓글들의 step 1씩 증가
		replyManageMapper.updateStep(replyBoard.getbGroupNo());
		// 2. mNo를 구하기 위한 작업
		mNo = boardCommonMapper.selectMNo(mId);
		replyBoard.setmNo(mNo);
		// 3. 댓글 작성
		return replyManageMapper.createReply(replyBoard);
	}
	
	@Override
	public int removeReply(int bNo) {
		return replyManageMapper.deleteReply(bNo);
	}
	
	@Override
	public int checkChoice(int bNo) {
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터를 작업하자
		return replyManageMapper.updateChoice(bNo);
	}
	
	@Override
	public int checkRecommend(int bNo) {
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터 작업
		return replyManageMapper.updateRecommend(bNo);
	}

	@Override
	public int findBoardReplyCount() {
		return viewMapper.selectBoardReplyCount();
	}
	
	@Override
	public int updateViewCount(int bNo) {
		return viewMapper.updateView(bNo);
	}
	
}
	 */
	/*
	@RequestMapping(value = "/ImgUpload2" )
    public void CkeditorImgUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload)throws Exception{
		System.out.println("시작");
        OutputStream out = null;
        PrintWriter printWriter = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("시작1");
        try{
            String fileName = upload.getOriginalFilename();
            System.out.println("시작2");
            String uploadPath = request.getSession().getServletContext().getRealPath("uploads") + '/' +fileName;//저장경로
            System.out.println("시작3");
            String fileUrl = "uploads/"+fileName;//url경로
            System.out.println("시작4");
            byte[] bytes = upload.getBytes();
            String callback = request.getParameter("CKEditorFuncNum");

            out = new FileOutputStream(new File(uploadPath));
            out.write(bytes);

            printWriter = response.getWriter();
            printWriter.println(
                    "<script>window.parent.CKEDITOR.tools.callFunction("
                    + callback
                    + ",'"
                    + fileUrl
                    + "','이미지를 업로드 하였습니다.'"
                    + ")</script>");
            printWriter.flush();

        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
	
	*/
	
	
	
	
}
