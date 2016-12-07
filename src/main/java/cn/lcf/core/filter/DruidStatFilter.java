package cn.lcf.core.filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
    @WebInitParam(name="sessionStatEnable",value="true"),
    @WebInitParam(name="profileEnable",value="true")
})
public class DruidStatFilter extends WebStatFilter {

}