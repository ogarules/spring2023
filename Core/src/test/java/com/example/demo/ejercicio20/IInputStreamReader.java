package com.example.demo.ejercicio20;

import java.io.InputStream;

@FunctionalInterface
public interface IInputStreamReader {
    String read(InputStream input) throws Exception;
}
