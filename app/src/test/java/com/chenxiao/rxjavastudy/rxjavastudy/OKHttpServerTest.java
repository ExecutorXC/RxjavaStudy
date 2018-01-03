package com.chenxiao.rxjavastudy.rxjavastudy;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by chenxiao on 18/1/3.
 */
public class OKHttpServerTest {
    @BeforeClass
    public void setUp() throws Exception {

    }

    @Test
    public void getInstance() throws Exception {
    }

    @Test
    public void run() throws Exception {
//        assertEquals("", OKHttpServer.getInstance().run("http://v5.pc.duomi.com/search-ajaxsearch-searchall?kw=勇气&pi=1&pz=10"));
    }

    @Test
    public void post() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("cmd", "1059");
        map.put("callback", "phone");
        map.put("phone", "13456265769");
        assertEquals("", OKHttpServer.getInstance().post2("http://www.baifubao.com/callback", map));
    }

    @Test
    public void post2() throws Exception {
    }

}