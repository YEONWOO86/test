package com.test.jdbc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.jdbc.dao.BoardDao;
import com.test.jdbc.dto.BDto;
import com.test.jdbc.service.BoardService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Autowired
   	private BoardService boardService;
//	 private BoardDao dao;
	
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        
        String formattedDate = dateFormat.format(date);
        
        model.addAttribute("serverTime", formattedDate );
        List<BDto> vo=boardService.listAll();
        model.addAttribute("list", vo);
        
        return "home";
    }
    
    @RequestMapping(value="/board_writeForm", method=RequestMethod.GET )
    @ResponseBody
	public String insertForm(Model model,HttpServletRequest request,HttpSession session){
			return "writeForm";
		// ajax 에서 문자값으로만 인식.. 페이지이동안됨. 
			// 밑에서 writeForm 받아서 이동해주는 클래스 만듬..
	}
    @RequestMapping(value="/writeForm", method=RequestMethod.GET )
    public String insertForm1(Model model,HttpServletRequest request,HttpSession session){
			return "writeForm";
		
	}
	
	@RequestMapping(value="/board_write", method=RequestMethod.POST )
	public String insert(HttpServletRequest request,Model model,HttpSession session){
				
		BDto bDto = new BDto();
		
		bDto.setbName(request.getParameter("write_bName"));
//		System.out.println(request.getParameter("bName"));
		
		bDto.setbTitle(request.getParameter("write_bTitle"));
//		System.out.println(request.getParameter("bTitle"));
		
		bDto.setbContent(request.getParameter("write_bContent"));
//		System.out.println(request.getParameter("bContent"));
//		bDto.setB_read_bTitle
		
		try{
			boardService.write(bDto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
		
	}
	@RequestMapping(value="/board_deleteForm" ,method=RequestMethod.GET )
	public String deleteForm(HttpServletRequest request,Model model){
		return "deleteForm";
	}
	@RequestMapping(value="/board_delete" ,method=RequestMethod.POST )
	public String delete(HttpServletRequest request,Model model){
		String name="";
		
		
		try{
			name = request.getParameter("delete_bName");
			boardService.delete(name);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/board_updateForm" ,method=RequestMethod.GET )
	public String updateForm(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
		System.out.println("board_updateForm1");
		
		String bName = request.getParameter("bName");
		System.out.println(bName);
		bDto= boardService.selectOne(bName);
		model.addAttribute("bDto", bDto);
		return "updateForm";
	}
	
//	@RequestMapping(value="/updateForm" ,method=RequestMethod.GET ) 
//	@ResponseBody
//	public String updateForm1(HttpServletRequest request,Model model){
//		BDto bDto = new BDto();
//		
//		String bName = request.getParameter("bName");
//		bDto= boardService.selectOne(bName);
//		model.addAttribute("bDto", bDto);
//		return "updateForm";
//	}
	@RequestMapping(value="/board_update" ,method=RequestMethod.POST ) 
	public String update(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
		
		bDto.setbName(request.getParameter("update_bName"));
		System.out.println(request.getParameter("update_bName"));
		
		bDto.setbTitle(request.getParameter("update_bTitle"));
		
		bDto.setbContent(request.getParameter("update_bContent"));
		try{
			boardService.update(bDto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	@RequestMapping(value="/board_selectOne", method=RequestMethod.GET)
	public String selectOne(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
		System.out.println(request.getParameter("bName"));
		String bName = request.getParameter("bName"); 
		try{
			bDto = boardService.selectOne(bName);
			model.addAttribute("ttt", bDto);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("10");
		}
		System.out.println("11");
		return "selectOne";
	}
	

}
