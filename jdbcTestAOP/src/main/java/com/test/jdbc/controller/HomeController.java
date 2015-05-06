package com.test.jdbc.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;

import org.hibernate.validator.internal.util.privilegedactions.SetAccessibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.jdbc.dto.BDto;
import com.test.jdbc.service.BoardService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Autowired
   	private BoardService boardService;
	private ModelAndView mav;
	
//	 private BoardDao dao;
	
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.info("Welcome home! The client locale is {}." );
        
       
    
//        System.out.println(jsonOb.toString());
        
        
//        List<BDto> vo=boardService.listAll();
//        model.addAttribute("list", vo);
      
       return "final_view";
       
        
    }
    
    @RequestMapping(value="/final_view", method=RequestMethod.GET)
    public void lastTry1(Model model){
    	
    }
    @RequestMapping(value="/final", method=RequestMethod.GET)
    public ModelAndView lastTry(){
    	 
    	        

    	        mav = new ModelAndView();
    	        mav.addObject("row", boardService.listAll());
    	        System.out.println(mav.toString());
    	        mav.setViewName("jsonView");
    	        
    	        
    	        return mav;
    	        
    }
  
	
	@RequestMapping(value="/board_write", method=RequestMethod.POST )
	/*@ResponseBody*/
	public String insert(@ModelAttribute("bDto") @Valid BDto bDto, Errors errors){
	
		
		if(errors.hasErrors()){
			System.out.println("add errors");
					
		}
		
			boardService.write(bDto);  // 이름 제목 내용으로 DB에 값들을 넣어준다.
			lastTry();
		
		return "final_view";
		
	}
	
	
	@RequestMapping(value="/board_deleteForm" ,method=RequestMethod.GET )
	public String deleteForm(HttpServletRequest request,Model model){
		return "deleteForm";
	}
	@RequestMapping(value="/board_delete" ,method=RequestMethod.GET )
	@ResponseBody
	public String delete(HttpServletRequest request,Model model){
		String name="";
		
			name = request.getParameter("bName"); //이름값을 받아 DB의 내용을 지운다
			boardService.delete(name);
		
		return "fincal_view";
	}
	

	@RequestMapping(value="/board_update" ,method=RequestMethod.POST ) 
	public String update(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
		
		bDto.setbName(request.getParameter("bName")); //이름값에 해당되는 글을 수정한다.
		System.out.println(request.getParameter("bName"));
		
		bDto.setbTitle(request.getParameter("bTitle"));
		
		bDto.setbContent(request.getParameter("bContent"));
		
		boardService.update(bDto);
		
		return "final_view";
	}
	@RequestMapping(value="/board_selectOne", method=RequestMethod.GET) //글상세보기
	public ModelAndView selectOne(@RequestParam("bName") String bName){
		
		mav = new ModelAndView();
		BDto bDto = new BDto();
		bDto = boardService.selectOne(bName);
		
		mav.addObject("row", bDto);
		mav.setViewName("jsonView");
		
		return mav;
	}


}
