package com.callor.memo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping(value="/memo")
@Controller
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="/m-list", method=RequestMethod.GET)
	public String list(Model model, Principal principal) {
		List<MemoVO> mList = memoService.findByUsername(principal.getName());
		model.addAttribute("MEMOLIST", mList);
		return "memo/m-list";
	}

	@RequestMapping(value="/m-list", method=RequestMethod.POST)
	public String insert(@ModelAttribute("memoVO") MemoVO memoVO
						,MultipartFile file, Principal principal) {
		memoVO.setM_username(principal.getName());
		log.debug("여기 insert {} ",memoVO);
		memoService.insert(memoVO);
		return "redirect:/memo/m-list";
	}
	
	@ModelAttribute("memoVO")
	public MemoVO makeMemo() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		MemoVO memoVO = MemoVO.builder()
				.m_date(dayFormat.format(date))
				.m_time(timeFormat.format(date))
				.build();
		return memoVO;
	}
	
	@RequestMapping(value="/{seq}/m-detail", method =RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model,
						 @ModelAttribute("memoVO") MemoVO memoVO) {
		memoVO.getM_seq();
		long m_seq = Long.valueOf(seq);
		memoVO = memoService.findById(m_seq);
		model.addAttribute("M_MEMO",memoVO);
		return "memo/m-detail";
	}
	
	@RequestMapping(value="/{seq}/update", method = RequestMethod.GET)
	public String update(
			@PathVariable("seq") String seq, Model model) {
		MemoVO memoVO = memoService.findById(Long.valueOf(seq));
		model.addAttribute("M_MEMO", memoVO);
		return "memo/m-add";
	}
	@RequestMapping(value="/{seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("seq") String seq, 
			@ModelAttribute("memoVO") MemoVO memoVO,
			MultipartFile file,
			HttpSession httpSession) {
		Long m_seq = Long.valueOf(seq);
		memoVO.setM_seq(m_seq);
		memoService.insertAndUpdate(memoVO,file);
		return String.format("redirect:/memo/%s/m-detail",seq);
	}
	
	@RequestMapping(value="/{seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		memoService.delete(Long.valueOf(seq));
		return "redirect:/";
	}
	
}
