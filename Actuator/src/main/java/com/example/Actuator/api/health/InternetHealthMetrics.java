package com.example.Actuator.api.health;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;

@Component
public abstract class InternetHealthMetrics implements HealthIndicator {

        public Health health(){

           return chechInternet()==true?Health.up().withDetail("Success Code","Internet Conenction").build():Health.down().withDetail("Error Code","IN ActiveInternet Conenction").build();

        }

        private boolean chechInternet(){
            boolean flag=false;

            try{

                URL url=new URL("https://www.google.com");

                URLConnection connection=url.openConnection();
                flag=true;
            }catch (Exception e){
                    flag=false;
            }
                return flag;
        }


}
