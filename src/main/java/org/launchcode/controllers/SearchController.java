package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.launchcode.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value = "results")
    public String processResultsForm(Model model, @RequestParam String searchType , @RequestParam String searchTerm){
        model.addAttribute("columns" , ListController.columnChoices);

        if (searchType.equals("all")) {
            model.addAttribute("columns" , ListController.columnChoices);
            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            model.addAttribute("jobs", jobs);

            return "search";
        }

        else {
            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("jobs", jobs);

            return "search";
        }


                //call correct jobDate method
                //return what jobData gives you

            }
            //return all jobs
           // return JobData.allJobs;
        }

        //search by column and value
        //return what we get



