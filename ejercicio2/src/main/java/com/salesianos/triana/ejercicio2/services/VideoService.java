package com.salesianos.triana.ejercicio2.services;


import com.salesianos.triana.ejercicio2.models.Video;
import com.salesianos.triana.ejercicio2.repositories.VideoRepository;
import com.salesianos.triana.ejercicio2.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class VideoService extends BaseService<Video, Long, VideoRepository> {
}
