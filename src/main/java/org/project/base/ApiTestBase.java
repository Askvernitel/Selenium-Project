package org.project.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class ApiTestBase  {

    @BeforeClass
    public void setup(){
    }


    @AfterClass
    public void teardown(){

    }

}
