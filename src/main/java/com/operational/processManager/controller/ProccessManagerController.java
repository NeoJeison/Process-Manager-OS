package com.operational.processManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.operational.processManager.service.ProcessManagerService;

@Controller
public class ProccessManagerController {

	@Autowired
	private ProcessManagerService processManagerService;
	
	@RequestMapping("/")
	public String listAllProcesses(Model model) {
		model.addAttribute("processes", processManagerService.getAllProcesses());
		return "ProcessManager";
	}
	
	@RequestMapping("/kill")
	public String killProcess(Model model, @RequestParam("pid") String pid, RedirectAttributes redAtt) {
		String statusMessage = processManagerService.killAProcess(pid);
		redAtt.addFlashAttribute("statusMessage", statusMessage);
		model.addAttribute("processes", processManagerService.getAllProcesses());
		return "ProcessManager";
	}
	
}
