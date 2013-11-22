class GradesController < ApplicationController

  def index
    @grades = Grades.all
  end

  def show
    @grade = Grade.find(params[:id])
  end

end
