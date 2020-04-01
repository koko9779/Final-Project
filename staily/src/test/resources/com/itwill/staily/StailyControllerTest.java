package com.itwill.staily;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itwill.guest.controller.annotation.GuestController;
import com.itwill.staily.admin.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
/*
@ContextConfiguration(locations = { "classpath:spring/annotation/application-config-jdbc-annotation.xml",
									"classpath:spring/annotation/mvc-config-annotation.xml"})
*/
@ContextConfiguration(locations = {"classpath:spring/application-config.xml","classpath:spring/mvc-config.xml"})
@WebAppConfiguration
public class StailyControllerTest {
	
	@Mock
//	GuestService guestService;
	AdminService adminService; 
	@InjectMocks
	private AdminController adminController;
//	private GuestController guestController;
	
	private MockMvc mockMvc;
	public MockHttpSession session;
    public MockHttpServletRequest request;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
		/*
		session = new MockHttpSession();
        request = new MockHttpServletRequest();
        request.setSession(session);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    */
	}

	/*
	 * 테스트 main
	 */
	@Test
	public void test_admin_main() throws Exception {
		mockMvc.perform(get("/admin")).andExpect(status().isOk())
				.andExpect(view().name("forward:/WEB-INF/views/admin/index.jsp"));
		
	}

	/*
	 * 테스트 guest_list
	 */
	@Test
	@Ignore
	public void test_guest_list() throws Exception {
		
		
		mockMvc.perform(get("/guest_list.do"))
		.andExpect(status().isOk())
		.andExpect(view().name("forward:/WEB-INF/views/guest_list.jsp"));
		verify(guestService).selectAll();
		
	}
	@Test
	@Ignore
	public void test_guest_view() throws Exception {
		 mockMvc.perform(get("/guest_view.do").param("guest_no", "3"))
		.andExpect(status().isOk())
		.andExpect(view().name("forward:/WEB-INF/views/guest_view.jsp"));
		 verify(guestService).selectByNo(3);
		
		
	}
}
