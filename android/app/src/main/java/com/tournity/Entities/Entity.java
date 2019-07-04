package com.tournity.Entities;

import java.io.IOException;

public interface Entity<T> {
    public T fromJSON(String json) throws IOException;
    public String toJSON() throws IOException;
}
