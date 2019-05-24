package com.cheng.lt4.service;

import com.cheng.lt4.entity.BookMenu;
import com.cheng.lt4.entity.Menu;
import com.cheng.lt4.entity.Suggestion;
import com.cheng.lt4.util.Tip;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; NormalOperationService
 * @author: SanCheng
 * @create: 2018-09-21 19:13
 **/
public interface NormalOperationService {
    Tip submitSuggestion(Suggestion suggestion);
    List<Menu> queryMenu();
    List<BookMenu> queryMenuById(String staffId);
    Tip submitBookMenu(BookMenu bookMenu);
    int queryBookTime();
}
