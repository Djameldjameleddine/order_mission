package com.bougsid.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.Serializable;

/**
 * Created by ayoub on 6/23/2016.
 */
@ManagedBean
@ViewScoped
public class StatisticsView implements Serializable {
    @Autowired
    private IStatisticsService statisticsService;

    @PostConstruct
    public void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
                getAutowireCapableBeanFactory().
                autowireBean(this);
//        this.statisticsService = OrderMissionApplication.getContext().getBean(IStatisticsService.class);
    }

}

