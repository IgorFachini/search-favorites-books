import React from "react";
import BookResult from "../components/BookResult";
import Grid from '@material-ui/core/Grid';


function ResultsContainer(props) {
	if (props.path === "/") {
		return (
			<div id="resultsContainer">
				{props.bookData.map((book) => {
					const bookInfo = book.volumeInfo;
					return <BookResult
						title={bookInfo.title}
						authors={bookInfo.authors ? bookInfo.authors.join(', ') : ''}
						description={bookInfo.description}
						link={bookInfo.canonicalVolumeLink}
						img={bookInfo.imageLinks}
						path={props.path}
						bookId={book.id}
						key={book.id} />
				})}
			</div>
		);
	} else if (props.path === "/saved") {
		if (props.savedBooks.length > 0) {
			return (
				<div id="resultsContainer">
					<Grid justify="center" container>
						<h3>Livros favoritos</h3>
					</Grid>
					{props.savedBooks.map((book) => {
						return <BookResult
							title={book.title}
							authors={book.authors}
							description={book.description}
							link={book.link}
							img={{ smalThumbnail: book.imgSmallThumbnail, thumbnail: book.imgThumbnail }}
							id={book.id}
							path={props.path}
							key={book.googleBookId} />
					})}
				</div>
			);
		} else {
			return (
				<div id="resultsContainer">
					<h3>Saved Books</h3>
					<p>No saved books.</p>
				</div>
			);
		}
	}
}

export default ResultsContainer;