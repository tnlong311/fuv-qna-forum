package com.qnaforum.webapp.mapper;

import com.qnaforum.webapp.model.dto.PostRequest;
import com.qnaforum.webapp.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

  public abstract Post map(PostRequest postRequest);
}
