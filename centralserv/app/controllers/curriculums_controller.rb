class CurriculumsController < ApplicationController

  def index
    @grade = Grade.find(params[:id])
  end

  def new
    @curriculum = Curriculum.new
  end

  def show
    @curriculum = Curriculum.find(params[:id])
  end

  def create
  end

end
