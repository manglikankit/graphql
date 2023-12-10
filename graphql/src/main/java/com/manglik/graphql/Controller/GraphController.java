package com.manglik.graphql.Controller;

import com.manglik.graphql.Entity.Graph;

import com.manglik.graphql.Service.GraphService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("graph")
@Controller
public class GraphController {

    @Autowired
    GraphService graphService;
//    @PostMapping
@MutationMapping(name = "createGraph")
public Graph createGraph(@Argument(name = "graph") GraphInput req)  {
    Graph g = new Graph();
//    g.setTitle(req.title());
//    g.setDescription(req.description());
//    g.setPrice(req.price());
//    g.setAddress(req.address());
    BeanUtils.copyProperties(req, g);
    return graphService.saveGraph( g);
}

//    @GetMapping
    @QueryMapping("allGraphs")
    public List<Graph> getAllGraphs(){
        return graphService.getAllGraph();
    }
//    @GetMapping("/{id}")
//    public Optional<Graph> getOrders(@PathVariable int id){
@QueryMapping("getGraph")
    public Optional<Graph> getGraph(@Argument int graphId){
        return graphService.getGraphByID(graphId);
    }
    @SchemaMapping(typeName = "Query")
    public Optional<Graph> graphById(@Argument("graphId") int graphId){
        return graphService.getGraphByID(graphId);
    }


//    @DeleteMapping("/{uId}")
//    public ResponseEntity<String> deleteOrder(@PathVariable int uId){
//        graphService.deleteOrder(uId);
//        return new ResponseEntity<>("User has been deleted successfully", HttpStatus.OK);
//    }
}
//@Getter
//@Setter
// class GraphInput{
//    private String title;
//    private String description;
//    private int price;
//    private String address;
//}
 record GraphInput(String title, String description, int price,String address ) {}
