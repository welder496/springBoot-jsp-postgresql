package br.jus.cnj.boot.app;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.jus.cnj.boot.app.model.Pessoa;
import br.jus.cnj.boot.app.repository.PessoaRepository;

@Controller
public class WelcomeController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Value("${application.message}")
	private String message = "Bem vindos ao mundo Spring Boot!!";
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public String cadastro(){
		return "form";
	}
	
	@RequestMapping(value="/trataform", method=RequestMethod.POST)
	public String trataform(@ModelAttribute Pessoa pessoa, Model model){
		model.addAttribute("nome",pessoa.getNome());
		pessoaRepository.save(pessoa);
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Map<String,Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/bobeira")
	public String bobeira(Map<String, Object> model) {
		throw new RuntimeException("Bobeira");
	}
	
}
