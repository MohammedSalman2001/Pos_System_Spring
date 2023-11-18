package lk.ijse.spring.controller;


import lk.ijse.spring.dto.core.ItemDto;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
@CrossOrigin
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> save(@ModelAttribute ItemDto dto){
//        System.out.println(dto.toString());
    ItemDto save = itemService.save(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",dto), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update(@RequestBody ItemDto dto){
        ItemDto update = itemService.update(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"update",update), HttpStatus.CREATED
        );
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<StandResponse> delete(@RequestParam String id){
        itemService.delete(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"deleted",null), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "list")
    public ResponseEntity<StandResponse> getAll(){
        List<ItemDto> all = itemService.findAll();
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",all), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{searchId}")
    public ResponseEntity<StandResponse> get(@PathVariable("searchId") String id){
        ItemDto itemDto = itemService.find(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"searchId",itemDto), HttpStatus.CREATED
        );

    }
}
