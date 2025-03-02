import 'package:flutter/material.dart';
import 'package:oktoast/oktoast.dart';
import 'package:zz_flutter_shop/page/my_search_delegate.dart';
import 'package:zz_flutter_shop/res/colors_manager.dart';

categoryAppBar(BuildContext context) {

  return AppBar(
    backgroundColor: ColorManager.white70, //导航栏和状态栏的的颜色
    elevation: 0, //阴影的高度,默认在导航栏下有4高度阴影

    //qrcode扫描按钮
    leading: IconButton(
      icon: const Icon(Icons.crop_free, color: ColorManager.grey),
      onPressed: () {
        showToast("扫一扫");
      },
    ),

    title: Container(
      height: 40,
      decoration: const BoxDecoration(
          borderRadius: BorderRadius.all(Radius.circular(50)),
          color: ColorManager.white),
      child: TextField(
        onTap: () {
          showSearch(context: context, delegate: MySearchDelegate());
        },
        decoration: const InputDecoration(
          hintText: '搜一搜!',
          hintStyle: TextStyle(
            fontSize: 14,
          ),
          suffixIcon: Icon(Icons.camera_alt, color: ColorManager.grey),
          prefixIcon: Icon(Icons.search, color: ColorManager.black),
          border: InputBorder.none,
        ),
      ),
    ),
    actions: <Widget>[
      IconButton(icon: const Icon(Icons.message, color: ColorManager.grey),
        onPressed: () {
          //todo 跳转到消息页面
          showToast("消息");
        },
      ),
    ],
  );

}