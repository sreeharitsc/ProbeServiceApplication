/**
 * 
 */
package com.maveric.probe.controller;

import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.probe.dto.CommandRequest;
import com.maveric.probe.dto.InitRequest;
import com.maveric.probe.dto.ProbeStatusResponse;
import com.maveric.probe.model.Grid;
import com.maveric.probe.model.Position;
import com.maveric.probe.service.ProbeManager;
import com.maveric.probe.service.ProbeService;

/**
 * @author sreehari
 *	Class used to represent Probe Controller which does following things
 *	Initialize the probe
 *  Send movement commands
 *  Get the current status and visited path
 */
@RestController
@RequestMapping("/api/probe")
public class ProbeController {

    @PostMapping("/init")
    public String initialize(@RequestBody InitRequest request) {
        Grid grid = new Grid(request.gridWidth, request.gridHeight, Collections.emptySet());
        Position start = new Position(request.startX, request.startY);
        ProbeManager.initialize(grid, start, request.direction);
        return "Probe initialized";
    }

    @PostMapping("/commands")
    public String executeCommands(@RequestBody CommandRequest request) {
        ProbeService probe = ProbeManager.getInstance();
        probe.moveSequence(request.commands);
        return "Commands executed";
    }

    @GetMapping("/status")
    public ProbeStatusResponse getStatus() {
        ProbeService probe = ProbeManager.getInstance();
        return new ProbeStatusResponse(probe.getCurrentPosition(), probe.getDirection(), probe.getVisitedPath());
    }
}
