package com.murattanriverdi.orm.presentation.mvc;

import com.murattanriverdi.orm.configuration.MyBean;
import com.murattanriverdi.orm.data.entity.Player;
import com.murattanriverdi.orm.data.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sports")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MyBean myBean;


    @GetMapping("/players/byteam")
    @ResponseBody
    public String getPLayersByTeam() {
        System.out.println("Çekirdek "+myBean.getMyLong() +" "+myBean.getMyString()+" "+myBean.getMyDouble());
        long teamId = 2;
        List<Player> players = playerRepository.findAllByTeamId(teamId);
        double totalScore =0;
        for(Player player : players){
            System.out.println("Player  :"+ player.getPlayerId() +" " + player.getPlayerName()+" "+player.getAverageScore());
            totalScore +=player.getAverageScore();
        }
        double averageScore = 0;
        if(!players.isEmpty()){
            averageScore = totalScore / players.size();
        }
        return "Oyuncu Sayısı : "+averageScore;
    }
}
