import axios from "axios";

export default {
    getBooks: () => {
        return axios.get("http://localhost:8082/favoriteBooks");
    },
    searchBooks: (title) => {
        return axios.get("http://localhost:8082/searchBooks?query=" + title);
    },
    addBookToDB: (bookData) => {
        return axios.post("http://localhost:8082/favoriteBooks", bookData);
    },
    deleteBook: (id) => {
        return axios.delete(`http://localhost:8082/favoriteBooks/${id}`);
    }
}