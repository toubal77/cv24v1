package fr.univrouen.cv24.controllers;

import java.util.NoSuchElementException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import fr.univrouen.cv24.services.CV2Service;
import jakarta.xml.bind.JAXBException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetController {

    	@Autowired
	private CV2Service cv24Service;

	@GetMapping(value =  {"/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
          return modelAndView;
      }
    @GetMapping(value = "/help")
    public ModelAndView help() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("help");
          return modelAndView;
      }
 
    @GetMapping(value = "/error")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
          return modelAndView;
      }

    @RequestMapping( value="/cv24/resume", method = RequestMethod.GET)
	@ResponseBody
	public String resume() throws TransformerException {
		return cv24Service.getAllCv24sHTML();
	}

	@RequestMapping( value="/cv24/resume/xml", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String resumeXML() throws TransformerException {
		return cv24Service.getAllCv24sXML();
	}

    @GetMapping(value="/cv24/xml", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String cvXML(@RequestParam Long id) throws NoSuchElementException, TransformerException, JAXBException {
		return cv24Service.findByIdXML(id);
	}

    @GetMapping(value="/cv24/html" ,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String cvHTML(@RequestParam Long id) throws NoSuchElementException, TransformerException {
		return cv24Service.findByIdHTML(id);
	}


}