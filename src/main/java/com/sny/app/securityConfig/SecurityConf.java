package com.sny.app.securityConfig;

import javax.sql.DataSource;

import org.apache.catalina.filters.CorsFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;


//@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity

public class SecurityConf extends WebSecurityConfigurerAdapter
{
      private Log log  = LogFactory.getLog(SecurityConf.class);
	  
       @Autowired
	   DataSource ds; //  DataSource  object autho wired 
      
       @Autowired
	   private  UserDetailsService userDetailService;  // its the sub type of UserDetailSeverviceImplementation  which implements the  UserDetailService interface 
       
       @Bean
       public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
           StrictHttpFirewall firewall = new StrictHttpFirewall();
           firewall.setAllowUrlEncodedSlash(true);    
           return firewall;
          }
      
       @Bean
	   BCryptPasswordEncoder getPasswordEncoder()
	   {
		   return new BCryptPasswordEncoder();
	   }
	  
      
        //@SuppressWarnings("deprecation")
		@Bean
	    public AuthenticationProvider authenticationProvider() {
	          DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	          auth.setUserDetailsService(userDetailService);
	           //auth.setPasswordEncoder(getPasswordEncoder());
	           //auth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	           //auth.setHideUserNotFoundExceptions(true);
	           auth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	           log.warn("we are at authentication provider method");
	        return auth;
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	   
	   
      
      @Override
	    protected void configure(HttpSecurity http) throws Exception
	    { 
       	//log .warn("now we are  congigur HttpSecurity method ");
    	  http.addFilterBefore(new MyCORSFilter(), ChannelProcessingFilter.class);
    	  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
       	 .and().csrf().disable()
         .anonymous()
       	 .and()
         .authorizeRequests().antMatchers("/user/**").hasAnyAuthority("USER","ADMIN")
         .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
       	 .antMatchers("test").permitAll()
       	 .antMatchers("/logout/both").permitAll()
       	 .and()
         .logout().clearAuthentication(true)
         .logoutSuccessUrl("/test")
         .deleteCookies("JSESSIONID")
         .invalidateHttpSession(true)  
       	 //.antMatchers("/logout/both").permitAll()
         //.anyRequest().permitAll()
       	 .and()
       	 .httpBasic();
         }


	@Override
	public void configure(WebSecurity web) throws Exception 
	{
	    // TODO Auto-generated method stub
		super.configure(web);
		web.httpFirewall( allowUrlEncodedSlashHttpFirewall());
	}
	     
}
