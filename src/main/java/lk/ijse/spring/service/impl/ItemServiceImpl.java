package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.core.ItemDto;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    private final ModelMapper mapper;


    @Autowired
    public ItemServiceImpl(ItemRepo itemRepo, ModelMapper mapper) {
        this.itemRepo = itemRepo;
        this.mapper = mapper;
    }

    public ItemDto save(ItemDto dto) {
        if(!itemRepo.existsById(dto.getCode())){
            System.out.println(dto);
            Item map = mapper.map(dto, Item.class);
            return mapper.map(itemRepo.save(map),ItemDto.class);
        }else {
            throw new RuntimeException("Item"+ dto.getCode() + "Already exist");
        }

    }

    public ItemDto update(ItemDto dto) {
        if(itemRepo.existsById(dto.getCode())){
            Item map = mapper.map(dto, Item.class);
            return mapper.map(itemRepo.save(map),ItemDto.class);
        }else {
            throw new RuntimeException("Item"+ dto.getCode() + "not Found");
        }

    }

    public void delete(String code) {
        if(itemRepo.existsById(code)){
            itemRepo.deleteById(code);

        }else {
            throw new RuntimeException("Item"+ code + "not Found");
        }
    }

    public ItemDto find(String code) {

        if(itemRepo.existsById(code)){
            Item byId = itemRepo.findById(code).get();
            return mapper.map(byId,ItemDto.class);
        }else {
            throw new RuntimeException("Item"+ code + "not Found");
        }

    }

    public List<ItemDto> findAll() {
        List<Item> all = itemRepo.findAll();
        return mapper.map(all, new TypeToken<List<ItemDto>>() {}.getType());

    }
}
