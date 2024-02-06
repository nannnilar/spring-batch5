package com.example.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
public class Addresses {
    public List<Address> list;

    public Addresses() {
    }

    public Addresses(Spliterator<Address> spliterator){
        list = StreamSupport.stream(spliterator,false).collect(Collectors.toList());
    }
}
