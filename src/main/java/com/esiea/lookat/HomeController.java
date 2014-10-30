package com.esiea.lookat;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.esiea.lookat.beans.Site;
import com.esiea.lookat.dao.DAOFactory;
import com.esiea.lookat.dao.SiteDao;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public static final String CONF_DAO_FACTORY = "daofactory";
    private SiteDao siteDao = null;

    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		siteDao = DAOFactory.getInstance().getSiteDao();
		
		Site site = new Site();
		site.setUrl("http://localhost.fr");
		site.setDescription("Une description");
		site.setNom("LOCALHOST");
		site.setIdCat(1);
		site.setNbClick(0);
		
		siteDao.creer( site );
		
		/*Site site2 = siteDao.trouver(6);

		site2.setDescription("MODIFICATION OK2 !");
		siteDao.modifier(site2);
		
		siteDao.supprimer(site2);
		
		site2 = siteDao.trouver(6);
		if (site2 != null) {
			model.addAttribute("monSite", site2.toString());
		}
		*/
		return "home";
	}
	
}
