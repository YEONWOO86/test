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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.jdbc.dao.BoardDao;
import com.test.jdbc.dto.BDto;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Autowired
    private BoardDao dao;
	
	
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
        List<BDto> vo=dao.listAll();
        model.addAttribute("list", vo);
        
        return "home";
    }
    
    @RequestMapping(value="/board_writeForm", method=RequestMethod.GET )
	public String insertForm(Model model,HttpServletRequest request,HttpSession session){
		
			return "writeForm";
		
	}
	

	
	@RequestMapping(value="/board_write", method=RequestMethod.POST )
	public String insert(HttpServletRequest request,Model model,HttpSession session){
		
		int res ;
				
		BDto bDto = new BDto();
		
		bDto.setbName(request.getParameter("write_bName"));
//		System.out.println(request.getParameter("bName"));
		
		bDto.setbTitle(request.getParameter("write_bTitle"));
//		System.out.println(request.getParameter("bTitle"));
		
		bDto.setbContent(request.getParameter("write_bContent"));
//		System.out.println(request.getParameter("bContent"));
//		bDto.setB_read_bTitle
		try{
			res = dao.write(bDto);
		
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
		int res;
		String name="";
		
		
		try{
			name = request.getParameter("delete_bName");
			res = dao.delete(name);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/board_updateForm" ,method=RequestMethod.GET )
	public String updateForm(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
		
		String bName = request.getParameter("bName");
		bDto= dao.selectOne(bName);
		model.addAttribute("bDto", bDto);
		return "updateForm";
	}
	@RequestMapping(value="/board_update" ,method=RequestMethod.POST )
	public String update(HttpServletRequest request,Model model){
		int res=0;
		BDto bDto = new BDto();
		
		bDto.setbName(request.getParameter("update_bName"));
		
		bDto.setbTitle(request.getParameter("update_bTitle"));
		
		bDto.setbContent(request.getParameter("update_bContent"));
//		bDto.setB_read_bTitle
		try{
			res = dao.update(bDto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	@RequestMapping(value="/board_selectOne", method=RequestMethod.GET)
	public String selectOne(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
//		System.out.println(request.getParameter("bName"));
		String bName = request.getParameter("bName"); 
		try{
			bDto = dao.selectOne(bName);
			model.addAttribute("ttt", bDto);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "selectOne";
	}
}
