package kh.edu.react.provider.controller;

import kh.edu.react.provider.dto.Clothes;
import kh.edu.react.provider.service.ClothesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    private ClothesServiceImpl clothesService;

    @GetMapping
    public List<Clothes> getAllClothes() {
        return clothesService.getAllClothes();
    }
// -parameters 라는 문구가 보이면 sql 컬럼명, dto 명칭과 매개변수 명칭이 일치하는지 확인
    @GetMapping("/{cId}")
    public Clothes getClothesById(@PathVariable("cId") int cId) {
        return clothesService.getClothesById(cId);
    }

    @PostMapping
    public void insertClothes(@RequestBody Clothes clothes) {
        clothesService.insertClothes(clothes);
    }

    @PutMapping
    public void updateClothes(@RequestBody Clothes clothes) {
        clothesService.updateClothes(clothes);
    }

    @DeleteMapping("/{cId}")
    public void deleteClothes(@PathVariable int cId) {
        clothesService.deleteClothes(cId);
    }
}