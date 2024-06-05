//package com.bebe.spring.order.controller;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.bebe.spring.order.service.OrdersService;
//import com.bebe.spring.vo.AddressVO;
//import com.bebe.spring.vo.OrdersAddressVO;
//import com.bebe.spring.vo.UsersVO;
//
//@Controller
//
//@RequestMapping(value = "/order")
//public class OrdersController {
//
//	OrdersService orderService;
//
//	@RequestMapping(value = "/order", method = RequestMethod.POST)
//	public ModelAndView orderInfo(ModelAndView mav, @RequestParam(value = "productNo") Integer[] pn,
//			@RequestParam(value = "orderPrice") Integer[] pr, @RequestParam(value = "orderColor") String[] color,
//			@RequestParam(value = "orderSize") String[] size, @RequestParam(value = "orderQty") Integer[] qty,
//			String[] productName, String[] productImg,
//			OrdersAddressVO oav, HttpSession session) {
//		UsersVO usersVO = (UsersVO) session.getAttribute("sessionUser");
//		String id="";
//		if(usersVO != null)  id = usersVO.getId();
//		oav.setId(id);
//
//		for (int i = 0; i < pn.length; i++) {
//			oav.setProductNo(pn[i]);
//			oav.setOrderPrice(pr[i]);
//			oav.setOrderColor(color[i]);
//			oav.setOrderSize(size[i]);
//			oav.setOrderQty(qty[i]);
//			oav.setProductName(productName[i]);
//			oav.setProductImg(productImg[i]);
//			orderService.insertOrders(oav);
//			orderService.deleteCart(oav);
//
//			orderService.sales(oav);
//			orderService.stock(oav);
//		}
//		System.out.println(oav);
//		mav.setViewName("/order/order_sc");
//		return mav;
//	}
//
////	@RequestMapping(value = "/order_sc", method = RequestMethod.POST)
////	public void TEST(ModelAndView mav, @RequestParam(value = "productNo") Integer[] pn,
////			@RequestParam(value = "orderPrice") Integer[] pr, @RequestParam(value = "orderColor") String[] color,
////			@RequestParam(value = "orderSize") String[] size, @RequestParam(value = "orderQty") Integer[] qty,OrdersAddressVO oav) {
////		for(int i = 0; i< pr.length; i++) {
////			System.out.println(pn[i] + pr[i] + color[i] +size[i] + qty[i]);
////	}
////		System.out.println(oav);
////	}
//
//	@RequestMapping(value = "/order_sc", method = RequestMethod.GET)
//	public String TEST() {
//		return "/order/order_sc";
//	}
//}
