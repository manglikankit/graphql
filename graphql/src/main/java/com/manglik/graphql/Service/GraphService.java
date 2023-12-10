package com.manglik.graphql.Service;
import com.manglik.graphql.Entity.Graph;
import com.manglik.graphql.Repo.GraphRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GraphService {

    @Autowired
    private GraphRepo graphRepo;
    public Graph saveGraph(Graph request)  {
        log.info("Graph has saved");
        return graphRepo.save(request);

    }
public List<Graph> getAllGraph(){
        List<Graph> graphs = graphRepo.findAll();
        if (graphs.size()>0){
            return graphs;
        }
        else{
            throw new RuntimeException("No graphs found");
        }
}
    public Optional<Graph> getGraphByID(int id) {
        Optional<Graph> graph = graphRepo.findById(id);
       if(graph.isPresent())
       {
            return graph;
        }
        else {
            throw new RuntimeException("Graph not found");
        }
    }

//    public void deleteOrder(int uId) {
//       if(orderRepo.deleteOrdersById(uId) == 0){
//           throw new RuntimeException("Order couldn't be deleted");
//       }
//    }
}
