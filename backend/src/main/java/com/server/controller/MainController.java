package com.server.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.server.model.enums.AnimalType;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import com.server.service.FarmingSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class MainController {

    private FarmingSystem system;

    public MainController() {
        system = new FarmingSystem();
    }

    /**
     * Main Page
     */
    @RequestMapping(value = "/", method = GET)
    public String main() {
        return "Farm Management System is running!";
    }




    /**
     * Does aggregation with group by - Provides animals who have drank and eaten more than user inputted food and water
     *
     * RECEIVES:
     * {
     *     animalType: AnimalType
     *     waterSpent: int
     *     foodSpent: int
     * }
     *
     * Returns: LivestockModel to JSON object.
     *
     */
    @RequestMapping(value = "/get/wateredAndFed", method = POST)
    public void getWateredAndFed(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
        AnimalType animalType = AnimalType.valueOf(map.get("animalType").toString().toUpperCase());
        int water_spent = (int) map.get("waterSpent");
        int food_spent = (int) map.get("foodSpent");
        JSONArray livestock = system.getWateredAndFed(animalType, water_spent, food_spent);

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(livestock);
        out.flush();
    }


    @RequestMapping(value = "/get/usertables", method = GET)
    public void getUserTables(HttpServletRequest req, HttpServletResponse res) throws IOException {
        JSONArray tables = system.getUserTables();
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(tables);
        out.flush();
    }

    @RequestMapping(value = "/get/tablecolumns", method = POST)
    public void getTableColumns(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
        JSONArray tables = system.getTableColumns(map.get("table_name").toString());
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(tables);
        out.flush();
    }

    /**
     * General PROJECTION Query
     * Sample Request Format: {
     *     "table":"LIVESTOCK_4",
     *     "columns": ["tagID", "age", "weight"]
     * }
     */
    @RequestMapping(value = "/get/values", method = POST)
    @SuppressWarnings("unchecked")
    public void doSelection(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
        ArrayList<String> columnsToSelect = (ArrayList<String>) map.get("columns");
        String tableToFrom = map.get("table").toString();

        JSONArray data = system.getSelect(columnsToSelect, tableToFrom);
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
    }


    /**
     * Does nested aggregation
     */
    @RequestMapping(value = "/get/maxCountFarmers", method = GET)
    public void getMaxCountFarmers(HttpServletResponse res) throws IOException {
        JSONArray data = system.findMaxCountNurtureFarmers();

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
    }

    @RequestMapping(value = "/get/overweight", method = GET)
    public void getOverweightAnimals(HttpServletResponse res) throws IOException {
        JSONArray data = system.findOverweightAnimals();

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
    }

    /**
     * Does division
     *
     * if:
     * type = 1 -> get all farmers who have nurtured all livestock
     * otherwise -> get all farmers who have tended all fields
     *
     * RECEIVES:
     * {
     *     param: 1 OR 2
     * }
     *
     */
    @RequestMapping(value = "/get/farmerDiv", method = POST)
    public void getAllFarmersDivision(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
        JSONArray data = system.findAllFarmerDivision((int) map.get("param"));
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
    }
      // For Ref!
    //    @RequestMapping(value = "/login", method = POST)
    //    public boolean login(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
    //
    //    }
}
