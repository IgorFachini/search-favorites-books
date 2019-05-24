import React from "react";
import API from "../utils/API";
import { BrowserRouter as Router } from "react-router-dom";

import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { withStyles } from "@material-ui/core/styles";
import Grid from '@material-ui/core/Grid';
import { connect } from 'react-redux';


const styles = theme => ({
	card: {
		margin: 15
	},
	media: {
		height: 460,
	},
});

class BookResult extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			saved: false,
			deleted: false
		}
		this.handleSaveClick = this.handleSaveClick.bind(this);
		this.handleDeleteClick = this.handleDeleteClick.bind(this);
	}

	handleSaveClick = function (e) {
		this.setState({ saved: true });
		const bookData = {
			userId: '1',
			googleBookId: this.props.bookId,
			title: this.props.title,
			authors: this.props.authors,
			link: this.props.link,
			imgSmallThumbnail: this.props.img.smalThumbnail || '',
			imgThumbnail: this.props.img.thumbnail || '',
			description: this.props.description
		}
		e.preventDefault();
		API.addBookToDB(bookData).then(
			(response) => {
				console.log(response);
			}
		).catch(
			(err) => {
				console.log(err);
			}
		);
	}

	handleDeleteClick(e) {
		this.setState({ deleted: true });
		e.preventDefault();
		API.deleteBook(this.props.id).then(
			(response) => {
				console.log(response);
				Router.dispatch(this.props.location, null)
			}
		).catch(
			(err) => {
				console.log(err);
			}
		);
	}

	render() {
		const { classes, user } = this.props;

		return (
			<div className="bookResult" id={(this.props.id) ? this.props.id : null} style={{ display: this.state.deleted ? "none" : "block" }}>
				<Card className={classes.card}>
					<Grid container>
						<Grid item xs={12} sm={4}>
							<CardMedia
								className={classes.media}
								image={(this.props.img.smallThumbnail) ? this.props.img.smallThumbnail :
									(this.props.img.thumbnail) ? this.props.img.thumbnail : ""}
								title="Contemplative Reptile"
							/>
						</Grid>
						<Grid item xs={12} sm={8}>
							<CardActions>
								{(this.props.link) ?
									<a href={this.props.link} target="_blank" rel="noopener noreferrer">
										<Button size="small" color="primary">
											view
											</Button>
									</a>
									: null
								}
								{(this.props.path === "/") ?
									<Button onClick={this.handleSaveClick} disabled={this.state.saved || !user} size="small" color="secondary">
										{(this.state.saved) ? "Saved" : "Save"}
									</Button>
									:
									<div>
										<Button onClick={this.handleDeleteClick} disabled={this.state.deleted || !user} size="small" color="secondary">
											Delete
										</Button>
									</div>
								}
							</CardActions>
							<CardContent>
								<Typography gutterBottom variant="h5" component="h2">
									{this.props.title}
								</Typography>
								<Typography gutterBottom variant="h6" component="h3">
									By: {(this.props.authors) ? this.props.authors : "N/A"}
								</Typography>
								<Typography variant="body2" color="textSecondary" component="p">
									{(this.props.description) ? this.props.description : "N/A"}
								</Typography>
							</CardContent>
						</Grid>
					</Grid>
				</Card>
			</div>
		);
	}
}

const mapStateToProps = store => ({
	user: store.dataReducer.user
});

BookResult = connect(mapStateToProps)(BookResult)

export default withStyles(styles)(BookResult);
