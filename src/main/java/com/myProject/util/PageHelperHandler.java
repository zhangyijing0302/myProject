package com.myProject.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

/**
 * @ClassName PageHelperHandler
 * @description: 集合分页处理
 **/
@Component
public class PageHelperHandler {


  public static int batchSize;

  @Value("${otcd.batch-insert.page-size:2000}")
  public void setBatchSize(int batchSize) {
    PageHelperHandler.batchSize = batchSize;
  }

  /**
   * Description: 分页（分页大小：默认2000） <br>
   */
  public static <T> List<List<T>> getListByPage(List<T> list) {
    //返回集合
    List<List<T>> userList = Lists.newArrayList();
    if (CollectionUtils.isEmpty(list)) {
      return userList;
    }
    //总数
    int totalSize = list.size();

    //分页大小
    int pageSize = totalSize < batchSize ? list.size() : batchSize;

    //总页
    int totalPage = totalSize % pageSize != 0 ? (totalSize / pageSize) + 1 : totalSize / pageSize;

    for (int pageNum = 1; pageNum < totalPage + 1; pageNum++) {
      int starNum = (pageNum - 1) * pageSize;
      int endNum = Math.min(pageNum * pageSize, totalSize);
      List<T> users = list.subList(starNum, endNum);
      userList.add(users);
    }
    return userList;
  }


  /**
   * Description: 分页 <br>
   *
   * @param pageSizeParam 每页大小
   * @author zk
   * @Time 2021/7/27 11:30
   */
  public static <T> List<List<T>> getListByPage(List<T> list, int pageSizeParam) {
    //返回集合
    List<List<T>> userList = Lists.newArrayList();
    if (CollectionUtils.isEmpty(list)) {
      return userList;
    }

    //总数
    int totalSize = list.size();

    //分页大小
    int pageSize = totalSize < pageSizeParam ? list.size() : pageSizeParam;
    //总页
    int totalPage = totalSize % pageSize != 0 ? (totalSize / pageSize) + 1 : totalSize / pageSize;

    for (int pageNum = 1; pageNum < totalPage + 1; pageNum++) {
      int starNum = (pageNum - 1) * pageSize;
      int endNum = pageNum * pageSize > totalSize ? (totalSize) : pageNum * pageSize;
      List<T> users = list.subList(starNum, endNum);
      userList.add(users);
    }
    return userList;
  }

}
