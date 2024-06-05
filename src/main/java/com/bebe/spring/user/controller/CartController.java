/*
package com.bebe.spring.user.controller;


import java.net.URLEncoder;
import java.util.ArrayList;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bebe.spring.user.service.CartService;
import com.bebe.spring.vo.CartVO;
import com.bebe.spring.vo.UsersVO;

@Controller

@RequestMapping("/user")
public class CartController {
	CartService cartService;

	// 테스트용
	@RequestMapping("/cart2")
	public ModelAndView cart(ModelAndView mav, HttpSession session, CartVO cv) {
		UsersVO usersVO = (UsersVO) session.getAttribute("sessionUser");
		String id="";
		if(usersVO != null)  id = usersVO.getId();		
		cv.setId(id);
		System.out.println(cv);
		mav.addObject("cart", cartService.cart(cv));
		mav.setViewName("/user/cart2");

		return mav;
	}

	@RequestMapping(value= "/delete",method = RequestMethod.POST)
	public ModelAndView delete(CartVO cv,String[] productColor, String[] productNo ,String[] checked,String[] productSize,  HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/user/cart2");
		UsersVO usersVO= (UsersVO) session.getAttribute("sessionUser");
		String id="";
		if(usersVO != null)  id = usersVO.getId();		
		cv.setId(id);
		for(int i= 0; i<checked.length;i++) {
			if(checked[i].equals("true")) {
				cv.setProductNo(Integer.parseInt(productNo[i]));
				cv.setProductColor(productColor[i]);
				cv.setProductSize(productSize[i]);
				cartService.delete(cv);
			}
		}
		return mav;
	}
	
	@RequestMapping(value = "/goOrder", method = RequestMethod.POST)
	   public ModelAndView order(CartVO cv, String[] productNo, String[] checked, String[] productSize,
	         String[] productColor, HttpSession session) {
	      ModelAndView mav = new ModelAndView("/order/order");
	      UsersVO usersVO = (UsersVO) session.getAttribute("sessionUser");
			String id="";
			if(usersVO != null)  id = usersVO.getId();		 
	      ArrayList<CartVO> list = new ArrayList<>();
	   
	      
	      for (int i = 0; i < checked.length; i++) {	
	         if (checked[i].equals("true")) {
	            System.out.println((i+1)+"번째 상품을 담습니다");
	            cv.setProductNo(Integer.parseInt(productNo[i]));
	            cv.setProductColor(productColor[i]);
	            cv.setProductSize(productSize[i]);
	            cv.setId(id);
	            System.out.println(cv);
	            list.add(cartService.order(cv));            
	         }            
	      }      
	      System.out.println(list);
	      mav.addObject("order", list);
	      return mav;
	   }
		
@ResponseBody
@RequestMapping(value = "/checkStock", method = RequestMethod.POST)
public String checkStock(CartVO cv, String[] productNo, String[] checked, String[] productSize,
		String[] productColor, String[] productName) throws Exception {
			Integer stock = 0;
			
			for (int i = 0; i < checked.length; i++) {
				if (checked[i].equals("true")) {
					cv.setProductNo(Integer.parseInt(productNo[i]));
					cv.setProductColor(productColor[i]);
					cv.setProductSize(productSize[i]);
					stock = cartService.checkSoldOut(cv);
					if(stock <= 0) {
					String str = productName[i] +","+productColor[i] +","+ productSize[i];
					return URLEncoder.encode(str, "UTF-8");
					}
				}				
			}	
		return "";
	}
}

	*/
