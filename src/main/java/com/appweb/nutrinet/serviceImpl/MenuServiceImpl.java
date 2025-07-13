package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.repository.MenuRepository;
import com.appweb.nutrinet.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
}
