package com.test.jdbc.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
      
       
        ArrayList b_list = (ArrayList)boardService.listAll();  //db의 값을 json 파일로 바꾸기 위해  값을 배열에 넣고
        JSONObject jsonOb = new JSONObject();				//들어간 데이터만큼을 for문으로 각 키에 값들을 넣어준다
        JSONArray jsonAr = new JSONArray();
        BDto data = null;
      
        for (int i = 0; i < b_list.size(); i++) {
        	
			data = (BDto)b_list.get(i);
        	JSONObject obj = new JSONObject();
        	
        	obj.put("bName", data.getbName());
//        	System.out.println("name = " + data.getbName());
        	obj.put("bTitle", data.getbTitle());
        	obj.put("bContent", data.getbContent());
        	
        	jsonAr.add(obj);
//        	System.out.println(jsonAr.toString());
        	
        }
//        System.out.println("1");
        jsonOb.put("row", jsonAr);  //최종적으로 반환할 json 형식
       
        model.addAttribute("list",jsonOb); 
        
//        System.out.println(jsonOb.toString());
        
        
      /*  List<BDto> vo=boardService.listAll();
        model.addAttribute("list", vo);
        return "home";*/
       return "home";
       
        
    }
   
    @RequestMapping(value="/board_writeForm", method=RequestMethod.GET )
    @ResponseBody
	public String insertForm(Model model,HttpServletRequest request,HttpSession session){
			return "writeForm";
		
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
		
/*	BDto bDto = new BDto();     //json 아직 미구현
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("json", request.getParameter("json_data"));
		JSONObject jsonObject = JSONObject.fromObject(mapJson);
		System.out.println(jsonObject.toString());*/
		
		
		
			boardService.write(bDto);  // 이름 제목 내용으로 DB에 값들을 넣어준다.
		
		
		
		return "redirect:/";
		
	}
	@RequestMapping(value="/board_deleteForm" ,method=RequestMethod.GET )
	public String deleteForm(HttpServletRequest request,Model model){
		return "deleteForm";
	}
	@RequestMapping(value="/board_delete" ,method=RequestMethod.POST )
	public String delete(HttpServletRequest request,Model model){
		String name="";
		
		
	
			name = request.getParameter("delete_bName"); //이름값을 받아 DB의 내용을 지운다
			boardService.delete(name);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/board_updateForm" ,method=RequestMethod.GET )
	public String updateForm(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
		System.out.println("board_updateForm1");
		
		String bName = request.getParameter("bName");  //이름값을 받아와 해당 글을 수정하는페이지로 간다.
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
		
		bDto.setbName(request.getParameter("update_bName")); //이름값에 해당되는 글을 수정한다.
		System.out.println(request.getParameter("update_bName"));
		
		bDto.setbTitle(request.getParameter("update_bTitle"));
		
		bDto.setbContent(request.getParameter("update_bContent"));
		
			boardService.update(bDto);
		
		
		
		
		return "redirect:/";
	}
	@RequestMapping(value="/board_selectOne", method=RequestMethod.GET) //글상세보기
	public String selectOne(HttpServletRequest request,Model model){
		BDto bDto = new BDto();
		System.out.println(request.getParameter("bName"));
		String bName = request.getParameter("bName"); 
		
			bDto = boardService.selectOne(bName);
			model.addAttribute("ttt", bDto);
		
		return "selectOne";
	}
	

}
