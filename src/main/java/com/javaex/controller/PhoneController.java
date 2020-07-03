package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) { //model은 변수, 디스패쳐 서블렛에 요청함. model 인스턴스 별도 생성시 오류남(생성하지 말것!)
		
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> pList = phoneDao.getPersonList();
		System.out.println(pList.toString());
		
		model.addAttribute("pList", pList); //모델을 담음
		
		return "list";
		
	}
	
	
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		return "writeForm";
	}
	
	
	@RequestMapping(value="/write", method= {RequestMethod.GET})
	public String write(@ModelAttribute PersonVo personVo) { //디스패쳐 서블렛에 신호보내기 
		System.out.println("/phone.write()");
		
		System.out.println(personVo.toString());
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}	
	
	
	 /*
	@RequestMapping(value="/write", method= {RequestMethod.GET})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam(value = "company", required=false, defaultValue="000") String company
						) { //디스패쳐 서블렛에 신호보내기 
		System.out.println("/phone.write()");
		
		PersonVo personVo = new PersonVo();
		
		System.out.println(personVo.toString());
		
		return "";
	}
	*/	
	
	/*
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model, @RequestParam("personId") int personId) {
		System.out.println("/updateForm");
		
		PhoneDao dao = new PhoneDao();
		PersonVo vo = dao.getPerson(personId);
		
		model.addAttribute("vo", vo);

		return "/WEB-INF/views/updateForm.jsp";
	}
	*/
	
	
	@RequestMapping(value="/updateForm/{personId}", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model, @PathVariable("personId") int personId) { //디스패쳐게게 모델에게 담아 전달
		System.out.println("/updateForm");
		
		PhoneDao dao = new PhoneDao();
		PersonVo vo = dao.getPerson(personId);
		
		model.addAttribute("vo", vo); //디스패쳐에게 전달. 모델에게 담아 전달.

		return "/WEB-INF/views/updateForm.jsp";
	}
	

	@RequestMapping(value="/update", method= {RequestMethod.GET})	
	public String update(@ModelAttribute PersonVo vo) {
		System.out.println("update");
		
		PhoneDao dao = new PhoneDao();
		dao.personUpdate(vo);
		
		return "redirect:/phone/list";
		
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET})	
	public String delete(@RequestParam("personId") int personId) {
		System.out.println("delete");
		
		PhoneDao dao = new PhoneDao();
		dao.personDelete(personId);

		
		return "redirect:/phone/list";
		
	}
	
	
	
}
