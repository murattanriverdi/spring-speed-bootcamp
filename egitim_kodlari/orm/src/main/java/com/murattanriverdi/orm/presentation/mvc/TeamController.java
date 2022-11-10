package com.murattanriverdi.orm.presentation.mvc;

import com.murattanriverdi.orm.data.entity.Player;
import com.murattanriverdi.orm.data.entity.Team;
import com.murattanriverdi.orm.data.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/sports")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/team/insert")
    @ResponseBody
    public String insertTeam() {
        Team teamA = new Team(0, "Godoro Spor");
        teamA.setPlayerList(new ArrayList<>());

        Player player1 = new Player(0, "Cem Karaca", 54.21);
        player1.setTeam(teamA);
        teamA.getPlayerList().add(player1);

        Player player2 = new Player(0, "Barış Manço", 64.23);
        player2.setTeam(teamA);
        teamA.getPlayerList().add(player2);

        Player player3 = new Player(0, "Fikret Kızıkok", 45.23);
        player3.setTeam(teamA);
        teamA.getPlayerList().add(player3);

        teamRepository.save(teamA);

        return "Kaydedildi:" + teamA.getTeamId();

    }
}
