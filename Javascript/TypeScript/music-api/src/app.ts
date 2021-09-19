import express from "express";

// Our Express APP config
const app = express();
app.use(express.json());
app.set("port",3000);

// API Endpoints
app.get("/", (req:any, res: any) => res.send("hi"));

app.listen(app.get("port"), () => {
  console.log("App is running on http://localhost:%d", app.get("port"));
});