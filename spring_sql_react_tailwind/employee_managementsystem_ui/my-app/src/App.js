
import './App.css';
import Navbar from './components/Navbar';
import AddEmployee from './components/AddEmployee';
import { BrowserRouter } from 'react-router-dom';
import EmployeeList from './components/EmployeeList';
import { Route, Routes } from 'react-router';
//Navbar nhu nhau
function App() {
  return(
  <>
    <BrowserRouter>
      <Navbar /> 
      <Routes>
        <Route index element ={<EmployeeList />}></Route>
        <Route path="/" element={<EmployeeList />}></Route>
        <Route path="/EmployeeList" element={<EmployeeList />}></Route>
        <Route path="/addEmployee" element ={<AddEmployee />}></Route>
      </Routes>
    </BrowserRouter>
  </>
  );
  }

export default App;
